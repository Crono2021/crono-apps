.class public Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SavedMessagesTags"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x684411a6


# instance fields
.field public tags:[Lorg/drinkless/tdlib/TdApi$SavedMessagesTag;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19140
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19141
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$SavedMessagesTag;)V
    .locals 0
    .param p1, "savedMessagesTagArr"    # [Lorg/drinkless/tdlib/TdApi$SavedMessagesTag;

    .line 19131
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19132
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTags;->tags:[Lorg/drinkless/tdlib/TdApi$SavedMessagesTag;

    .line 19133
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19137
    const v0, -0x684411a6

    return v0
.end method
