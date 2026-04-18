.class public Lorg/drinkless/tdlib/TdApi$SearchChatMembers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchChatMembers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatMembers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a92b93b


# instance fields
.field public chatId:J

.field public filter:Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;

.field public limit:I

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45006
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45007
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ILorg/drinkless/tdlib/TdApi$ChatMembersFilter;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "chatMembersFilter"    # Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;

    .line 44994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44995
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMembers;->chatId:J

    .line 44996
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMembers;->query:Ljava/lang/String;

    .line 44997
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMembers;->limit:I

    .line 44998
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMembers;->filter:Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;

    .line 44999
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45003
    const v0, -0x1a92b93b

    return v0
.end method
