.class public Lorg/drinkless/tdlib/TdApi$PasswordState;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PasswordState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1cd63828


# instance fields
.field public hasPassportData:Z

.field public hasPassword:Z

.field public hasRecoveryEmailAddress:Z

.field public loginEmailAddressPattern:Ljava/lang/String;

.field public passwordHint:Ljava/lang/String;

.field public pendingResetDate:I

.field public recoveryEmailAddressCodeInfo:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51615
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;ZZLorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;Ljava/lang/String;I)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "emailAddressAuthenticationCodeInfo"    # Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "i9"    # I

    .line 51599
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51600
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->hasPassword:Z

    .line 51601
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->passwordHint:Ljava/lang/String;

    .line 51602
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->hasRecoveryEmailAddress:Z

    .line 51603
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->hasPassportData:Z

    .line 51604
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->recoveryEmailAddressCodeInfo:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;

    .line 51605
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->loginEmailAddressPattern:Ljava/lang/String;

    .line 51606
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$PasswordState;->pendingResetDate:I

    .line 51607
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51611
    const v0, 0x1cd63828

    return v0
.end method
