.class public Lorg/drinkless/tdlib/TdApi$MessageWebAppDataSent;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageWebAppDataSent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4fcc6ee


# instance fields
.field public buttonText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16980
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16981
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16971
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16972
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageWebAppDataSent;->buttonText:Ljava/lang/String;

    .line 16973
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16977
    const v0, -0x4fcc6ee

    return v0
.end method
