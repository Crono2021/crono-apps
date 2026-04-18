.class public Lorg/drinkless/tdlib/TdApi$RecoveryEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecoveryEmailAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4cebddeb


# instance fields
.field public recoveryEmailAddress:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18402
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18403
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18393
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18394
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RecoveryEmailAddress;->recoveryEmailAddress:Ljava/lang/String;

    .line 18395
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18399
    const v0, 0x4cebddeb    # 1.2366217E8f

    return v0
.end method
