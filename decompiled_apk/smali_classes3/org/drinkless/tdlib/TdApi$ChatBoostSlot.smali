.class public Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostSlot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x757fac7


# instance fields
.field public cooldownUntilDate:I

.field public currentlyBoostedChatId:J

.field public expirationDate:I

.field public slotId:I

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46760
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46761
    return-void
.end method

.method public constructor <init>(IJIII)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I
    .param p5, "i11"    # I
    .param p6, "i12"    # I

    .line 46747
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46748
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;->slotId:I

    .line 46749
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;->currentlyBoostedChatId:J

    .line 46750
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;->startDate:I

    .line 46751
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;->expirationDate:I

    .line 46752
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSlot;->cooldownUntilDate:I

    .line 46753
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46757
    const v0, 0x757fac7

    return v0
.end method
