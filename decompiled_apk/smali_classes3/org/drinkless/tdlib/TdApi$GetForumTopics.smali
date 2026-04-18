.class public Lorg/drinkless/tdlib/TdApi$GetForumTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetForumTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ForumTopics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x518e3adc


# instance fields
.field public chatId:J

.field public limit:I

.field public offsetDate:I

.field public offsetForumTopicId:I

.field public offsetMessageId:J

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49870
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49871
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;IJII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "j9"    # J
    .param p7, "i10"    # I
    .param p8, "i11"    # I

    .line 49856
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49857
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->chatId:J

    .line 49858
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->query:Ljava/lang/String;

    .line 49859
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->offsetDate:I

    .line 49860
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->offsetMessageId:J

    .line 49861
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->offsetForumTopicId:I

    .line 49862
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopics;->limit:I

    .line 49863
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49867
    const v0, 0x518e3adc

    return v0
.end method
