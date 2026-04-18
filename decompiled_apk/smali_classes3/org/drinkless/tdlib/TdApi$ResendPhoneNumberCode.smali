.class public Lorg/drinkless/tdlib/TdApi$ResendPhoneNumberCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResendPhoneNumberCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6bcea427


# instance fields
.field public reason:Lorg/drinkless/tdlib/TdApi$ResendCodeReason;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18852
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18853
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ResendCodeReason;)V
    .locals 0
    .param p1, "resendCodeReason"    # Lorg/drinkless/tdlib/TdApi$ResendCodeReason;

    .line 18843
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18844
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ResendPhoneNumberCode;->reason:Lorg/drinkless/tdlib/TdApi$ResendCodeReason;

    .line 18845
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18849
    const v0, 0x6bcea427

    return v0
.end method
