.class public Lorg/drinkless/tdlib/TdApi$MessageWebAppDataReceived;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageWebAppDataReceived"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x82e5eb


# instance fields
.field public buttonText:Ljava/lang/String;

.field public data:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28784
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28785
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 28774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28775
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageWebAppDataReceived;->buttonText:Ljava/lang/String;

    .line 28776
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageWebAppDataReceived;->data:Ljava/lang/String;

    .line 28777
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28781
    const v0, -0x82e5eb

    return v0
.end method
