.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFlashCall;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeFlashCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x533379a2


# instance fields
.field public pattern:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8845
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 8835
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8836
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFlashCall;->pattern:Ljava/lang/String;

    .line 8837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8841
    const v0, 0x533379a2

    return v0
.end method
