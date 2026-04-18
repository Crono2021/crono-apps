.class public Lorg/drinkless/tdlib/TdApi$CallDiscardReasonUpgradeToGroupCall;
.super Lorg/drinkless/tdlib/TdApi$CallDiscardReason;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallDiscardReasonUpgradeToGroupCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ac64b07


# instance fields
.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallDiscardReason;-><init>()V

    .line 9259
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 9249
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallDiscardReason;-><init>()V

    .line 9250
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallDiscardReasonUpgradeToGroupCall;->inviteLink:Ljava/lang/String;

    .line 9251
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9255
    const v0, 0x4ac64b07    # 6497667.5f

    return v0
.end method
