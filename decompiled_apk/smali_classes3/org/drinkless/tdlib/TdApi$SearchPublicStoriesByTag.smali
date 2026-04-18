.class public Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByTag;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchPublicStoriesByTag"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundStories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x69fbb14a


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public storyPosterChatId:J

.field public tag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45055
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I

    .line 45042
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45043
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByTag;->storyPosterChatId:J

    .line 45044
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByTag;->tag:Ljava/lang/String;

    .line 45045
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByTag;->offset:Ljava/lang/String;

    .line 45046
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByTag;->limit:I

    .line 45047
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45051
    const v0, 0x69fbb14a

    return v0
.end method
