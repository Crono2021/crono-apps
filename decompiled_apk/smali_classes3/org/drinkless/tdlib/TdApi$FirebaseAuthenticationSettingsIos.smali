.class public Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettingsIos;
.super Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettings;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FirebaseAuthenticationSettingsIos"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xd49a4c4


# instance fields
.field public deviceToken:Ljava/lang/String;

.field public isAppSandbox:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettings;-><init>()V

    .line 25525
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 25514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettings;-><init>()V

    .line 25515
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettingsIos;->deviceToken:Ljava/lang/String;

    .line 25516
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$FirebaseAuthenticationSettingsIos;->isAppSandbox:Z

    .line 25517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25521
    const v0, 0xd49a4c4

    return v0
.end method
