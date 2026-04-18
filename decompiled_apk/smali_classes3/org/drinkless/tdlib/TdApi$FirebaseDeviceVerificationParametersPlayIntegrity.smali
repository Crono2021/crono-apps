.class public Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParametersPlayIntegrity;
.super Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FirebaseDeviceVerificationParametersPlayIntegrity"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x350b5a76


# instance fields
.field public cloudProjectNumber:J

.field public nonce:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;-><init>()V

    .line 25545
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 25534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;-><init>()V

    .line 25535
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParametersPlayIntegrity;->nonce:Ljava/lang/String;

    .line 25536
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParametersPlayIntegrity;->cloudProjectNumber:J

    .line 25537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25541
    const v0, -0x350b5a76    # -8016581.0f

    return v0
.end method
