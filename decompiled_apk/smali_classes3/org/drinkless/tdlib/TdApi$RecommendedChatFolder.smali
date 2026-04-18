.class public Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecommendedChatFolder"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e284b4a


# instance fields
.field public description:Ljava/lang/String;

.field public folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29829
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatFolder;Ljava/lang/String;)V
    .locals 0
    .param p1, "chatFolder"    # Lorg/drinkless/tdlib/TdApi$ChatFolder;
    .param p2, "str"    # Ljava/lang/String;

    .line 29818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29819
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;->folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 29820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RecommendedChatFolder;->description:Ljava/lang/String;

    .line 29821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29825
    const v0, -0x7e284b4a

    return v0
.end method
