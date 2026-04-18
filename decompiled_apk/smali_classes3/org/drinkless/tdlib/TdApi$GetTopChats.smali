.class public Lorg/drinkless/tdlib/TdApi$GetTopChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetTopChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1726addf


# instance fields
.field public category:Lorg/drinkless/tdlib/TdApi$TopChatCategory;

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26765
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TopChatCategory;I)V
    .locals 0
    .param p1, "topChatCategory"    # Lorg/drinkless/tdlib/TdApi$TopChatCategory;
    .param p2, "i9"    # I

    .line 26754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26755
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetTopChats;->category:Lorg/drinkless/tdlib/TdApi$TopChatCategory;

    .line 26756
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetTopChats;->limit:I

    .line 26757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26761
    const v0, -0x1726addf

    return v0
.end method
