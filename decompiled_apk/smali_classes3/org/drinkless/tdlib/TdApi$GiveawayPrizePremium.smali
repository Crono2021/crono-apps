.class public Lorg/drinkless/tdlib/TdApi$GiveawayPrizePremium;
.super Lorg/drinkless/tdlib/TdApi$GiveawayPrize;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayPrizePremium"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1b12e978


# instance fields
.field public monthCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayPrize;-><init>()V

    .line 14155
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 14145
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayPrize;-><init>()V

    .line 14146
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayPrizePremium;->monthCount:I

    .line 14147
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14151
    const v0, 0x1b12e978

    return v0
.end method
