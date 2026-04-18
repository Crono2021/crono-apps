.class public Lorg/drinkless/tdlib/TdApi$Chats;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Chats"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6bdd241c


# instance fields
.field public chatIds:[J

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24504
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24505
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 24494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24495
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Chats;->totalCount:I

    .line 24496
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Chats;->chatIds:[J

    .line 24497
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24501
    const v0, 0x6bdd241c

    return v0
.end method
