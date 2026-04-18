.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultDocument;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58e2f3bb


# instance fields
.field public description:Ljava/lang/String;

.field public document:Lorg/drinkless/tdlib/TdApi$Document;

.field public id:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43759
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Document;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "str3"    # Ljava/lang/String;

    .line 43746
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43747
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultDocument;->id:Ljava/lang/String;

    .line 43748
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultDocument;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 43749
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultDocument;->title:Ljava/lang/String;

    .line 43750
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultDocument;->description:Ljava/lang/String;

    .line 43751
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43755
    const v0, -0x58e2f3bb

    return v0
.end method
