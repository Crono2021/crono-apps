.class public Lorg/drinkless/tdlib/TdApi$MessageSendOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSendOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66da4a52


# instance fields
.field public allowPaidBroadcast:Z

.field public disableNotification:Z

.field public effectId:J

.field public fromBackground:Z

.field public onlyPreview:Z

.field public paidMessageStarCount:J

.field public protectContent:Z

.field public schedulingState:Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;

.field public sendingId:I

.field public suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;

.field public updateOrderOfInstalledStickerSets:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53830
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53831
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;ZZZZJZLorg/drinkless/tdlib/TdApi$MessageSchedulingState;JIZ)V
    .locals 0
    .param p1, "inputSuggestedPostInfo"    # Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "j5"    # J
    .param p8, "z12"    # Z
    .param p9, "messageSchedulingState"    # Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;
    .param p10, "j9"    # J
    .param p12, "i9"    # I
    .param p13, "z13"    # Z

    .line 53811
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53812
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$InputSuggestedPostInfo;

    .line 53813
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->disableNotification:Z

    .line 53814
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->fromBackground:Z

    .line 53815
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->protectContent:Z

    .line 53816
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->allowPaidBroadcast:Z

    .line 53817
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->paidMessageStarCount:J

    .line 53818
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->updateOrderOfInstalledStickerSets:Z

    .line 53819
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->schedulingState:Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;

    .line 53820
    iput-wide p10, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->effectId:J

    .line 53821
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->sendingId:I

    .line 53822
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$MessageSendOptions;->onlyPreview:Z

    .line 53823
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53827
    const v0, -0x66da4a52

    return v0
.end method
