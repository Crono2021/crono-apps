.class public Lorg/drinkless/tdlib/TdApi$MessageDocument;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2394ab77


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public document:Lorg/drinkless/tdlib/TdApi$Document;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28405
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Document;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 28394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28395
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageDocument;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 28396
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageDocument;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 28397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28401
    const v0, 0x2394ab77

    return v0
.end method
