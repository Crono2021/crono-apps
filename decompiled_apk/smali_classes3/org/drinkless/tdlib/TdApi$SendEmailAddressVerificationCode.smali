.class public Lorg/drinkless/tdlib/TdApi$SendEmailAddressVerificationCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendEmailAddressVerificationCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xd35ac83


# instance fields
.field public emailAddress:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19285
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19275
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19276
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendEmailAddressVerificationCode;->emailAddress:Ljava/lang/String;

    .line 19277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19281
    const v0, -0xd35ac83

    return v0
.end method
