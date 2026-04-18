.class public Lorg/drinkless/tdlib/TdApi$SearchContacts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchContacts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Users;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6af8ce9b


# instance fields
.field public limit:I

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30589
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 30578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30579
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchContacts;->query:Ljava/lang/String;

    .line 30580
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SearchContacts;->limit:I

    .line 30581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30585
    const v0, -0x6af8ce9b

    return v0
.end method
