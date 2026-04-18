.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultAnimation;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x77cded0b


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public id:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37820
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37821
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Animation;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;
    .param p3, "str2"    # Ljava/lang/String;

    .line 37809
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37810
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultAnimation;->id:Ljava/lang/String;

    .line 37811
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 37812
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultAnimation;->title:Ljava/lang/String;

    .line 37813
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37817
    const v0, 0x77cded0b

    return v0
.end method
