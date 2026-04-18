.class public Lorg/drinkless/tdlib/TdApi$GiveawayInfoOngoing;
.super Lorg/drinkless/tdlib/TdApi$GiveawayInfo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayInfoOngoing"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x624ee050


# instance fields
.field public creationDate:I

.field public isEnded:Z

.field public status:Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37732
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayInfo;-><init>()V

    .line 37733
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;Z)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "giveawayParticipantStatus"    # Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;
    .param p3, "z8"    # Z

    .line 37721
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayInfo;-><init>()V

    .line 37722
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoOngoing;->creationDate:I

    .line 37723
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoOngoing;->status:Lorg/drinkless/tdlib/TdApi$GiveawayParticipantStatus;

    .line 37724
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoOngoing;->isEnded:Z

    .line 37725
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37729
    const v0, 0x624ee050

    return v0
.end method
