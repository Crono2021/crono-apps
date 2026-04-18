.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeJoinChat;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposeJoinChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x72229878


# instance fields
.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 20869
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20859
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 20860
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeJoinChat;->inviteLink:Ljava/lang/String;

    .line 20861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20865
    const v0, -0x72229878

    return v0
.end method
