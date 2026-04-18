.class public Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatusAdministrator;
.super Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayParticipantStatusAdministrator"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x37b4c58b


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14100
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;-><init>()V

    .line 14101
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14091
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;-><init>()V

    .line 14092
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatusAdministrator;->chatId:J

    .line 14093
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14097
    const v0, -0x37b4c58b

    return v0
.end method
