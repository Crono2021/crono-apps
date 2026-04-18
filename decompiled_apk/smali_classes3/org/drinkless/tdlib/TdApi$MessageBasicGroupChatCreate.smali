.class public Lorg/drinkless/tdlib/TdApi$MessageBasicGroupChatCreate;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageBasicGroupChatCreate"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2f68e71c


# instance fields
.field public memberUserIds:[J

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28245
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "jArr"    # [J

    .line 28234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28235
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageBasicGroupChatCreate;->title:Ljava/lang/String;

    .line 28236
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageBasicGroupChatCreate;->memberUserIds:[J

    .line 28237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28241
    const v0, 0x2f68e71c

    return v0
.end method
