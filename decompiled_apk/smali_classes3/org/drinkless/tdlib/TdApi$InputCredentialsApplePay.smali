.class public Lorg/drinkless/tdlib/TdApi$InputCredentialsApplePay;
.super Lorg/drinkless/tdlib/TdApi$InputCredentials;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputCredentialsApplePay"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4a4d292f


# instance fields
.field public data:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 14569
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14559
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 14560
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputCredentialsApplePay;->data:Ljava/lang/String;

    .line 14561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14565
    const v0, -0x4a4d292f

    return v0
.end method
