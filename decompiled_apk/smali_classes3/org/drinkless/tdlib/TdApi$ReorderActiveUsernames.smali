.class public Lorg/drinkless/tdlib/TdApi$ReorderActiveUsernames;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderActiveUsernames"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1b24d7cf


# instance fields
.field public usernames:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18655
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 18645
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18646
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderActiveUsernames;->usernames:[Ljava/lang/String;

    .line 18647
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18651
    const v0, -0x1b24d7cf

    return v0
.end method
