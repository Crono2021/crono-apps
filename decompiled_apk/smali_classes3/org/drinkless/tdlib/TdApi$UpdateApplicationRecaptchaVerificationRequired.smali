.class public Lorg/drinkless/tdlib/TdApi$UpdateApplicationRecaptchaVerificationRequired;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateApplicationRecaptchaVerificationRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6b122642


# instance fields
.field public action:Ljava/lang/String;

.field public recaptchaKeyId:Ljava/lang/String;

.field public verificationId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41451
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 41439
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41440
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationRecaptchaVerificationRequired;->verificationId:J

    .line 41441
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationRecaptchaVerificationRequired;->action:Ljava/lang/String;

    .line 41442
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateApplicationRecaptchaVerificationRequired;->recaptchaKeyId:Ljava/lang/String;

    .line 41443
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41447
    const v0, -0x6b122642

    return v0
.end method
