.class public Lorg/drinkless/tdlib/TdApi$Stories;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Stories"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x27f1cb1b


# instance fields
.field public pinnedStoryIds:[I

.field public stories:[Lorg/drinkless/tdlib/TdApi$Story;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40900
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40901
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$Story;[I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "storyArr"    # [Lorg/drinkless/tdlib/TdApi$Story;
    .param p3, "iArr"    # [I

    .line 40889
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40890
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Stories;->totalCount:I

    .line 40891
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Stories;->stories:[Lorg/drinkless/tdlib/TdApi$Story;

    .line 40892
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Stories;->pinnedStoryIds:[I

    .line 40893
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40897
    const v0, 0x27f1cb1b

    return v0
.end method
