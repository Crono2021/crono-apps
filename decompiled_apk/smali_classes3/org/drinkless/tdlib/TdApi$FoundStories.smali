.class public Lorg/drinkless/tdlib/TdApi$FoundStories;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundStories"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x640c1568


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public stories:[Lorg/drinkless/tdlib/TdApi$Story;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37070
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37071
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$Story;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "storyArr"    # [Lorg/drinkless/tdlib/TdApi$Story;
    .param p3, "str"    # Ljava/lang/String;

    .line 37059
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37060
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundStories;->totalCount:I

    .line 37061
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundStories;->stories:[Lorg/drinkless/tdlib/TdApi$Story;

    .line 37062
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundStories;->nextOffset:Ljava/lang/String;

    .line 37063
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37067
    const v0, 0x640c1568

    return v0
.end method
